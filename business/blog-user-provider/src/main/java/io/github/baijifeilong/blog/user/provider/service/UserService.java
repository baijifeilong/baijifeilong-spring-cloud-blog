package io.github.baijifeilong.blog.user.provider.service;

import io.github.baijifeilong.blog.user.api.domain.User;
import io.github.baijifeilong.blog.user.provider.exception.UserExistException;
import io.github.baijifeilong.blog.user.provider.exception.UserNotExistException;
import org.apache.commons.codec.digest.DigestUtils;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

import static io.github.baijifeilong.blog.generated.jooq.blog.Tables.USER;

/**
 * @author BaiJiFeiLong@gmail.com
 * @date 2019-04-24 14:55
 */
@SuppressWarnings("WeakerAccess")
@Service
public class UserService {

    @Resource
    private DSLContext dslContext;

    public User createUser(String username, String password) {
        Optional<User> optionalUser = findUserByUsername(username);
        if (optionalUser.isPresent()) {
            throw new UserExistException(username);
        }
        String encryptedPassword = encryptPassword(password);
        return dslContext.insertInto(USER)
                .set(USER.USERNAME, username)
                .set(USER.ENCRYPTED_PASSWORD, encryptedPassword)
                .returning()
                .fetchOne()
                .into(User.class);
    }

    public Optional<User> findUserByUsername(String username) {
        return dslContext.selectFrom(USER)
                .where(USER.USERNAME.eq(username))
                .fetchOptionalInto(User.class);
    }

    @SuppressWarnings("UnusedReturnValue")
    public User findUserByUsernameOrThrow(String username) {
        return findUserByUsername(username).orElseThrow(() -> new UserNotExistException(username));
    }

    public Optional<User> findUserById(int id) {
        return dslContext.selectFrom(USER)
                .where(USER.ID.eq(id))
                .fetchOptionalInto(User.class);
    }

    public User findUserByIdOrThrow(int id) {
        return findUserById(id).orElseThrow(() -> new UserNotExistException("id=" + id));
    }

    public String encryptPassword(String password) {
        return DigestUtils.md5Hex(password);
    }
}

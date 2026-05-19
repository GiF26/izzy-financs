package com.github.gif26.izzy_financs.repository;

import com.github.gif26.izzy_financs.model.Account;
import com.github.gif26.izzy_financs.model.User;
import com.github.gif26.izzy_financs.model.enums.AccountTypeEnum;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends CrudRepository<Account,Long> {

    @Modifying
    @Query("UPDATE Account a SET a.description = :description , a.accountType = :typeAccount " +
            "WHERE a.user.id = :userId " +
            "AND a.id = :id")
    void updateAccount(@Param("userId")Long userId,
                       @Param("id") long id,
                       @Param("description") String description,
                       @Param("typeAccount") AccountTypeEnum typeAccount);
    List<Account> findAccountsByUserId(long userId);

    @Modifying
    void deleteAccountByUserAndId(User userId, long accountId);
}

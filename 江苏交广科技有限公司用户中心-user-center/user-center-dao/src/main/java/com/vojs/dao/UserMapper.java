package com.vojs.dao;

import com.vojs.bean.domain.*;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户数据库操作
 *
 * Created by apple on 16/5/1.
 */
@Repository
public interface UserMapper {

    /**
     *  添加一条用户信息
     *
     * @param user
     * @return
     */
    int insertUser(User user);

    /**
     * 根据用户手机号查询用户数量
     * @param mobile
     * @return
     */
    int getUserCountByMobile(@Param("mobile") String mobile);

    /**
     * 根据union信息查询符合条件列表
     * @param wxUnion
     * @return
     */
    List<WXUnion> getWXUnionList(WXUnion wxUnion);

    /**
     * 添加一条union信息
     * */
    int insertUnion(WXUnion wxUnion);

    /**
     * 批量插入数据
     * @param wxUnions
     * @return
     */
    int batchInsertUnion(List<WXUnion> wxUnions);

    /**
     * 根据用户编号更新信息
     * @param userId
     * @return
     */
    int updateUnionByUserIdForDelete(@Param("userId") String userId);

    /**
     * 批量插入微信数据
     * @param wxAccounts
     * @return
     */
    int batchInsertWXOpenUser(List<WXAccount> wxAccounts);

    /**
     * 根据unionId更新删除标记
     * @param unionId
     * @return
     */
    int updateWXOpenUserByUnionIdForDelete(@Param("unionId") String unionId);

    /**
     * 更新用户信息
     *
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 根据user条件查询用户
     *
     * @param user
     * @return
     */
    List<User> getUser(User user);

    /**
     * 根据unionId查询关联用户
     *
     * @param unionId
     * @return
     */
    List<User> getUserByUnion(@Param("unionId") String unionId);

    /**
     * 根据微信的账号和openId查询用户
     *
     * @param publicAccount
     * @param openId
     * @return
     */
    List<User> getUserByUnionOpenIdAndAccount(@Param("unionId") String unionId,
                                           @Param("publicAccount") String publicAccount,
                                           @Param("openId") String openId);

    /**
     * 根据unionId获取所有微信账户
     * @param unionId
     * @return
     */
    List<WXAccount> getWXUserInfoByUnionId(@Param("unionId") String unionId);

    /**
     * 根据qq开放平台账号查询关联的用户
     *
     * @param qqAppId
     * @param qqOpenId
     * @return
     */
    List<User> getUserByQQ(@Param("qqAppId") String qqAppId, @Param("qqOpenId") String qqOpenId);



    /**
     * 根据qq及用户查询qq数量
     * @param qqAppId
     * @param qqOpenId
     * @return
     */
    int getUserQQCount(@Param("qqAppId") String qqAppId,
                       @Param("qqOpenId") String qqOpenId);


    /**
     * 新增标签
     * @param tag
     * @return
     */
    int insertTag(Tag tag);

    /**
     * 新增联系方式
     * @param contact
     * @return
     */
    int insertContact(Contact contact);

    /**
     * 查询活动联系方式
     * @param contactObject
     * @return
     */
	Contact queryContact(Contact contactObject);

	/**
	 * 查询微信账户信息
	 * @param wxPublicAccount
	 * @param wxUnionId
	 * @return
	 */
	List<WXAccount> getWxAccount(@Param("wxPublicAccount") String wxPublicAccount,
								 @Param("wxUnionId") String wxUnionId);

    /**
     * 添加一条登陆记录
     * @param uuid
     * @return
     */
	int insertLoginRecord(@Param("uuid") String uuid);

    /**
     * 查询当天指定用户的登陆记录
     *
     * @param uuid
     * @return
     */
	int queryLoginByUuid(@Param("uuid") String uuid);
}

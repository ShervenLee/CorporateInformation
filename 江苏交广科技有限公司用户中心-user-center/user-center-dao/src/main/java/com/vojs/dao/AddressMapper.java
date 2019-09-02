package com.vojs.dao;

import com.vojs.bean.domain.Address;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by chenyunjie on 2017/4/28.
 */
@Repository
public interface AddressMapper {

    /**
     * 根据不同条件查询
     *
     * @param address
     * @return
     */
    List<Address> selectAddressList(Address address);

    /**
     * 根据id进行删除
     * @param id
     * @return
     */
    int deleteAddress(@Param("id") long id, @Param("uuid") String uuid);

    /**
     * 更新地址
     * @param address
     * @return
     */
    int updateAddress(Address address);

    /**
     * 更新地址为非default
     * @param address
     * @return
     */
    int setAddressUndefaultExceptId(Address address);

    /**
     * 新增地址
     * @param address
     * @return
     */
    int insertAddress(Address address);

}

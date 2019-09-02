package com.vojs.dao;

import com.vojs.bean.domain.PayTimes;
import com.vojs.bean.form.AddTradeForm;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TradeMapper {

    /**
     * 插入一条订单信息
     *
     * @param tradeForm
     * @return
     */
    int insertTrade(AddTradeForm tradeForm);

    int updateUserPayTimes(PayTimes payTimes);

    List<PayTimes> queryUserPayTimesByUuid(@Param("uuid") String uuid);

    int insertUserPayTimes(PayTimes payTimes);

    /**
     * 修改登陆记录支付状态
     *
     * @return
     */
    int updateLoginRecordPayState(@Param("uuid") String uuid);
}

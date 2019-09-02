package com.vojs.service;

import com.vojs.bean.domain.PayTimes;
import com.vojs.bean.exception.VOJSException;
import com.vojs.bean.form.AddTradeForm;
import com.vojs.dao.TradeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TradeService {

    @Autowired
    private TradeMapper tradeMapper;

    public void addTrade(AddTradeForm tradeForm) throws VOJSException {
        try {
            tradeMapper.insertTrade(tradeForm);

            //增加用户支付次数
            List<PayTimes> payTimesList = tradeMapper.queryUserPayTimesByUuid(tradeForm.getUuid());

            if (payTimesList.size() > 0) {
                //存在则count+1
                PayTimes payTimes1 = payTimesList.get(0);
                payTimes1.setCount(payTimes1.getCount() + 1);
                tradeMapper.updateUserPayTimes(payTimes1);
            } else {
                //否则count=1
                PayTimes payTimes = new PayTimes();
                payTimes.setCount(1);
                payTimes.setUuid(tradeForm.getUuid());
                payTimes.setStatisticsTime(new Date().getTime());
                tradeMapper.insertUserPayTimes(payTimes);
            }

            //更新支付
            tradeMapper.updateLoginRecordPayState(tradeForm.getUuid());

        } catch (Exception e) {
            throw new VOJSException("新增支付记录失败");
        }
    }

}

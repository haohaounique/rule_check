package com.unique.rule.check.service;

import com.unique.framework.common.http.http.PageQuery;
import com.unique.framework.common.http.http.PageResult;
import com.unique.framework.common.http.http.ReqBody;
import com.unique.rule.check.controller.req.RuleConfigAddReq;
import com.unique.rule.check.controller.req.RuleConfigPageSearchReq;
import com.unique.rule.check.controller.resp.RuleConfigResp;
import com.unique.rule.check.entity.RuleConfig;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 规则配置 服务类
 * </p>
 *
 * @author haohaounique
 * @since 2025-03-15 16:37:01
 */
public interface IRuleConfigService extends IService<RuleConfig> {

    PageResult<List<RuleConfigResp>> pageSearch(ReqBody<PageQuery<RuleConfigPageSearchReq>> reqBody);

    boolean addRuleConfig(RuleConfigAddReq param);

    Object checkParam(Map<String, String> param);
}

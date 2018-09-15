package ${basePackage}.web;

import com.google.common.collect.Maps;
import ${basePackage}.dto.BaseRequestBody;
import ${basePackage}.dto.BaseResult;
import ${basePackage}.entity.${className};
import ${basePackage}.entity.User;
import ${basePackage}.enums.ResultEnum;
import ${basePackage}.exception.BizException;
import ${basePackage}.misc.Constants;
import ${basePackage}.service.I${className}Service;
import ${basePackage}.service.SystemService;
import ${basePackage}.util.SessionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.*;

/**
 * Created by wangyaoyao.
 */
@Controller
@RequestMapping("/${smallClassName}")
public class ${className}Controller {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());
    @Autowired
    I${className}Service ${smallClassName}Service;
    @Autowired
    SystemService systemService;

    /**
     * 列表
     * @param offset
     * @param limit
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public BaseResult<Object> list(Integer offset, Integer limit) {
        List<${className}> list = null;
        try {

            offset = offset == null ? 0 : offset;
            limit = limit == null ? Constants.DEFALUT_LIMIT : limit;

            list = ${smallClassName}Service.listPage(offset, limit,null);

        } catch (BizException e) {
            return new BaseResult<Object>(false, e.getMessage());
        } catch (Exception e) {
            if(Constants.Debug()) e.printStackTrace();
            return new BaseResult<Object>(false, ResultEnum.INNER_ERROR.getMsg());
        }
        return new BaseResult<Object>(true, list);
    }

    <#--/**-->
     <#--* 获取单个对象-->
     <#--*/-->
    <#--@ResponseBody-->
    <#--@RequestMapping(value = "/get",method = RequestMethod.GET)-->
    <#--public BaseResult<Object> get(Integer id) {-->
        <#--if(id <= 0) return new BaseResult<Object>(false,  ResultEnum.INVALID_DEPARTMENT.getMsg());-->

        <#--Map<Object, Object> map = null;-->
        <#--if(id !=null && id > 0){-->
            <#--map = Maps.newHashMap();-->
            <#--map.put("id",id);-->
        <#--}-->
        <#--${className} bean = null;-->
        <#--try {-->
            <#--bean = ${smallClassName}Service.selectObjByMap(map);-->
        <#--} catch (BizException e) {-->
            <#--return new BaseResult<Object>(false, e.getMessage());-->
        <#--} catch (Exception e) {-->
            <#--if(Constants.Debug()) e.printStackTrace();-->
            <#--return new BaseResult<Object>(false, ResultEnum.INNER_ERROR.getMsg());-->
        <#--}-->
        <#--if(bean == null) return new BaseResult<Object>(false,  ResultEnum.INVALID_DEPARTMENT.getMsg());-->
        <#--return new BaseResult<Object>(true, bean);-->
    <#--}-->
    /**
     * 保存
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST,produces = {Constants.HEADER_CONTENT_TYPE_JSON})
    @ResponseBody
    public BaseResult<Object> save(@Valid @RequestBody BaseRequestBody<${className}> body, BindingResult result, HttpServletRequest request) {
        User loginuser = SessionUtil.getSessionUser(request);
        ${className} bean = null;
        int resultCode = -1;
        try {
            bean = body.getData();
            resultCode = ${smallClassName}Service.insertSelective(bean);
            systemService.log(loginuser,request.getRequestURI());
        } catch (BizException e) {
            return new BaseResult<Object>(false, e.getMessage());
        } catch (Exception e) {
            if(Constants.Debug()) e.printStackTrace();
            return new BaseResult<Object>(false, ResultEnum.INNER_ERROR.getMsg());
        }
        if(resultCode <= 0) return new BaseResult<Object>(false,  ResultEnum.DEPT_SAVE_ERROR.getMsg());
        return new BaseResult<Object>(true, bean);
    }
    /**
     * 删除
     * @param body
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST,produces = {Constants.HEADER_CONTENT_TYPE_JSON})
    @ResponseBody
    public BaseResult<Object> delete(@Valid @RequestBody BaseRequestBody<${className}> body, BindingResult result, HttpServletRequest request) {
        ${className} bean = null;
        int resultCode = -1;
        try {
            bean = body.getData();
            resultCode = ${smallClassName}Service.deleteByPrimaryKey(bean.getId());
            LOG.info("resultCode="+resultCode);
        } catch (BizException e) {
            return new BaseResult<Object>(false, e.getMessage());
        } catch (Exception e) {
            if(Constants.Debug()) e.printStackTrace();
            return new BaseResult<Object>(false, ResultEnum.INNER_ERROR.getMsg());
        }
        if(resultCode <= 0) return new BaseResult<Object>(false,  ResultEnum.DEPT_DELETE_ERROR.getMsg());
        return new BaseResult<Object>(true, bean);
    }
    /**
     * 修改
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST,produces = {Constants.HEADER_CONTENT_TYPE_JSON})
    @ResponseBody
    public BaseResult<Object> update(@Valid @RequestBody BaseRequestBody<${className}> body, BindingResult result, HttpServletRequest request){
        ${className} bean = null;
        int resultCode = -1;
        try {
            bean = body.getData();
            resultCode = ${smallClassName}Service.updateByPrimaryKeySelective(bean);
        } catch (BizException e) {
            return new BaseResult<Object>(false, e.getMessage());
        } catch (Exception e) {
            if(Constants.Debug()) e.printStackTrace();
            return new BaseResult<Object>(false, ResultEnum.INNER_ERROR.getMsg());
        }
        if(resultCode <= 0) return new BaseResult<Object>(false,  ResultEnum.DEPT_UPDATE_ERROR.getMsg());
        return new BaseResult<Object>(true, bean);
    }
    /**
     * Treedata返回JSON结构
     */
    @RequestMapping(value = "/treedata", method = RequestMethod.GET)
    @ResponseBody
    public BaseResult<Object> treedata(HttpServletRequest request, HttpServletResponse response) {

        response.setContentType(Constants.HEADER_CONTENT_TYPE_JSON);
        String treedata = get${className}Tree();
        return new BaseResult<Object>(true,null, treedata);
    }
    //###############################################################################################################//
    //                                             自定义controller的方法
    //###############################################################################################################//

    //TODO HERE

    //###############################################################################################################//
    //                                               私有方法区域
    //###############################################################################################################//
        /**
     * 获取treedata树型结构
     */
    public String get${className}Tree(){
        return "{}";
    }
}

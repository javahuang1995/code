package com.huang.controller;

import java.util.List;

import com.huang.common.pojo.EUTreeNode;
import com.huang.common.pojo.TaotaoResult;
import com.huang.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 商品分类管理controller
 * <p>Title: ItemCatController</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.com</p>
 *
 * @version 1.0
 * @author 入云龙
 * @date 2015年9月4日上午9:25:14
 */
@Controller
@RequestMapping("/itemcat")
public class ItemCatController
{

    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping("/list")
    @ResponseBody
    private List<EUTreeNode> getCatList(@RequestParam(value = "id", defaultValue = "0") Long parentId)
    {
        List<EUTreeNode> list = itemCatService.getCatList(parentId);
        return list;
    }

    @RequestMapping("/create")
    @ResponseBody
    public TaotaoResult addItemCat(long parentId, String name)
    {
        TaotaoResult result = itemCatService.addItemCat(parentId, name);
        return result;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public TaotaoResult deleteItemCat(@RequestParam("id") Long id)
    {
        TaotaoResult result = itemCatService.deleteItemCat(id);
        return result;
    }

    @RequestMapping("/update")
    @ResponseBody
    public TaotaoResult updateItemCat(Long id, String name)
    {
        TaotaoResult result = itemCatService.updateIetmCat(id, name);
        return result;
    }


}

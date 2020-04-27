package com.springboottemplate.redis.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.springboottemplate.redis.annotation.DeleteCache;
import com.springboottemplate.redis.annotation.QueryCache;
import com.springboottemplate.redis.entity.TbItem;
import com.springboottemplate.redis.mapper.TbItemMapper;
import com.springboottemplate.redis.result.CacheNameSpace;
import com.springboottemplate.redis.service.TbItemService;

import tk.mybatis.mapper.entity.Example;

@Service
@Primary
public class TbItemServiceImpl implements TbItemService {

	@Autowired
	private TbItemMapper tbItemMapper ;

	/**
	 * 
	 * 获取商品： 如果缓存存在，从缓存中获取商品信息 如果缓存不存在，从DB中获取商品信息，然后插入缓存
	 * 
	 */
	@Override
	@QueryCache(nameSpace = CacheNameSpace.ITEM)
	public List<TbItem> GetTbItems() {

		Example example = new Example(TbItem.class);

		List<TbItem> tbItems = tbItemMapper.selectByExample(example);
		return tbItems;
	}

	@Override
	public TbItem GetTbItem(Long id) {
		//直接根据主键返回商品实体
		return tbItemMapper.selectByPrimaryKey(id);
	}

	@Override
	@DeleteCache(nameSpace = CacheNameSpace.ITEM)
	public boolean SaveTbItems(TbItem tbItem) {
		/**
		 * 这里不做操作，只是模拟，到这一步的时候，切面执行删除查询的时候写入缓存中的key
		 */
	
		return true;
	}

}

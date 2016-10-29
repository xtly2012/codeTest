package com.chen.lambda;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaTest {
	public static void main(String[] argus) {
		List<GoodsBean> goodsList = Arrays.asList(new GoodsBean(new BigDecimal("3"), 1),
				new GoodsBean(new BigDecimal("2"), 2),
				new GoodsBean(new BigDecimal("6"), 3));

		final List<ParamBean> paramList = Arrays.asList(new ParamBean(1, 2),
				new ParamBean(2, 7),
				new ParamBean(3, 9));


		BigDecimal orderAmount = goodsList.stream().map(goodsBean -> {
            Integer goodsNum = paramList.stream().filter(paramBean -> paramBean.getGoodsId() == goodsBean.getGoodsId()).findFirst().get().getGoodsNum();
            return goodsBean.getSellPrice().multiply(new BigDecimal(goodsNum));
        }).collect(Collectors.toList()).stream().reduce(BigDecimal.ZERO,BigDecimal::add);

        List<BigDecimal> list = goodsList.stream().map(goodsBean -> goodsBean.getSellPrice()).collect(Collectors.toList());

        System.out.println("orderAmount = " + list);
		
	}
	
	
}

class GoodsBean {
	private BigDecimal sellPrice;
	
	private Integer goodsId;
	
	public GoodsBean(BigDecimal sellPrice, Integer goodsId) {
		this.sellPrice = sellPrice;
		this.goodsId = goodsId;
	}

	public BigDecimal getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(BigDecimal sellPrice) {
		this.sellPrice = sellPrice;
	}

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	
}


class ParamBean {
	
	private Integer goodsId;
	
	private Integer goodsNum;
	
	public ParamBean(Integer goodsId, Integer goodsNum) {
		this.goodsId = goodsId;
		this.goodsNum = goodsNum;
	}

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public Integer getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(Integer goodsNum) {
		this.goodsNum = goodsNum;
	}
	
}



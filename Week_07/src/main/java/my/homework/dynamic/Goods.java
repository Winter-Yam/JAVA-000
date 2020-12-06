package my.homework.dynamic;


import java.io.Serializable;
import java.math.BigDecimal;

public class Goods {


    private String goodsName;

    private String no;

    private String introduce;

    private BigDecimal actualPrice;

    private BigDecimal marketPrice;

    private Integer stock;

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public BigDecimal getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(BigDecimal actualPrice) {
        this.actualPrice = actualPrice;
    }

    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Goods init(){
        this.goodsName= "测试商品";
        this.no= "商品编号";
        this.introduce= "介绍";
        this.actualPrice= new BigDecimal(1);
        this.marketPrice= new BigDecimal(2);
        this.stock = 10;
        return this;
    }
}

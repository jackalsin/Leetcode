package google.patternFinder;

/**
 * 第五轮：输入为一组 patterns: /api/customer/..customerld
 * /api/customer/:customerid/payment
 * /api/customer/:customerid/payment/:paymentid
 * /api/product/:productid
 * 其中以：开头为路径参数，可以为任意字母和数字，给出一个url，比如说/api/customer/123456/payment,给出对应的pattern(可以返回index或者其他的，自己决定)
 *
 * @author jacka
 * @version 1.0on 5/8/2021
 */

public interface Solution {

  int pattern(String url);
}

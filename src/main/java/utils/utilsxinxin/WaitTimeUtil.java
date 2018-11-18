package utils.utilsxinxin;

import exceptionTools.ErrorOnDataException;

/**
 * Created by lixx on 2018-09-15.
 */
public class WaitTimeUtil {
    /**
     * sleep函数
     * @param millis
     * 毫秒
     */
    public static void sleep(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 等待页面元素加载，设定时间内找到对象则立即退出，否则一直查找，直至报错超时
     *@param locator
     *             - 页面元素，需要在defineElement中定义
     *@param timeout
     *             - 超时时间，单位为秒
     */
    public void waitForElementPresent(String locator,int timeout){
        if (timeout > 100){
            throw new ErrorOnDataException("100秒以上超时等待！不合理，还是找开发GG看看吧。又或者你把秒当成毫秒使了？");
        }else if (timeout < 1){
            throw new ErrorOnDataException("超时时间大于等于1");
        }
        waitPageLoad();
    }
    public void waitPageLoad(){
        pageWaitLoad(30);
    }
    /**
     * 使用JS等待页面加载完成
     * @param timeout
     *            -超时时间
     */
    public void pageWaitLoad(int timeout) {
/*    String stateJString="return window.document.readyState";
    for(int i=0;i<timeout;i++){
        sleep(1000);//防止页面短暂跳转，click方法误以为页面完成加载
        try{
            if (runScript(stateJString).equals("complete")){
                return;
            }
        }catch (Exception e){
          //JS执行异常时，硬编码5秒后等待后返回
            sleep(5000);
            return;
        }
    }
        throw new TimeoutException("页面"+timeout);
        */
    }
}

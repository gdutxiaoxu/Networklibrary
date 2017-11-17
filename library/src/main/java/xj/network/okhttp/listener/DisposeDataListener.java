package xj.network.okhttp.listener;

import xj.network.okhttp.exception.OkHttpException;

/**********************************************************
 * @文件名称：DisposeDataListener.java
 * @文件作者：renzhiqiang
 * @创建时间：2015年8月19日 上午11:01:13
 * @文件描述：业务逻辑层真正处理的地方，包括java层异常和业务层异常
 * @修改历史：2015年8月19日创建初始版本
 **********************************************************/
public interface DisposeDataListener<T> {

	/**
	 * 请求成功回调事件处理
	 */
	public void onSuccess(T t);

	/**
	 * 请求失败回调事件处理
	 */
	public void onFailure(OkHttpException e);

}

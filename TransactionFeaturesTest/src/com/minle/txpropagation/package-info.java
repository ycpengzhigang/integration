/**
 * spring的事物传播级别的测试
 * propagation-required：支持当前事物,
 * propagation-support：支持当前事物,没有事物就不在事物中运行
 * propagation-required-new:事物存在就将当前事物挂起，创建一个新的事物。
 * propagation_mandatory：支持当前事物,没有就抛出异常
 * propagation_not_supported：以非事物的方式执行,如果当前事物存在,则将当前事物挂起。
 * propagation_never：以非事物的方式执行,如果当前存在事物存在，就抛出异常。
 */
package com.minle.txpropagation;
package com.jpldx.ioc.java.beans;

import java.beans.*;
import java.util.stream.Stream;

/**
 * {@link java.beans.BeanInfo} 示例
 * @author chen.xudong
 * @version 1.0
 * @since 2021/3/25
 */
public class BeanInfoDemo {

    public static void main(String[] args) throws IntrospectionException {

        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class);// 自省方式

        Stream.of(beanInfo.getPropertyDescriptors()).forEach(propertyDescriptor ->{
            // 返回3个属性，其中 name=class 是因父类 Object#getClass() 解析而来，可以指定 stopClass = Object.class 进行父类属性排除
            System.out.println(propertyDescriptor);

            // PropertyDescriptor 允许添加属性编辑器 - PropertyEditor
            // GUI: text(String) -> PropertyType 类型转换
            String propertyName = propertyDescriptor.getName();
            if("age".equals(propertyName)){ // 为 "age" 属性添加 PropertyEditor
                // String -> Integer
                // Integer.valueOf("")
                propertyDescriptor.setPropertyEditorClass(String2IntegerPropertyEditor.class);
            }
        });

    }

    static class String2IntegerPropertyEditor extends PropertyEditorSupport{
        @Override
        public void setAsText(String text) {
           Integer value = Integer.valueOf(text);
           setValue(value);
        }
    }
}

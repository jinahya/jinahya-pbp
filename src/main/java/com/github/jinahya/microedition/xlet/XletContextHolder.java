/*
 * Copyright 2014 <a href="mailto:onacit@gmail.com">Jin Kwon</a>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package com.github.jinahya.microedition.xlet;


import com.github.jinahya.util.AtomicHolder;
import javax.microedition.xlet.XletContext;


/**
 * A utility class holding an {@link XletContext}.
 * <p>
 * <blockquote><pre>
 * {@code
 * public void initXlet(final XletContext xletContext) {
 *     XletContextHolder.getIntstance().set(xletContext);
 *     // other statements here
 * }
 *
 * public void destroyXlet(final boolean unconditional) {
 *     // other statements here
 *     XletContextHolder.getInstance().set(null);
 * }
 * }
 * </pre></blockquote>
 * </p>
 * Not any codes executed between {@code initXlet} and {@code destroyXlet} can
 * use it like this.
 * <p>
 * <blockquote><pre>
 * {@code
 * class SomeOther {
 *     public void doSomethingWithXletContext() {
 *         final XletContext xletContext
 *             = (XletContext) XletContextHolder.getInstance().get();
 *         // do something with xletContext
 *     }
 * }
 * }
 * </pre></blockquote>
 * </p>
 *
 * @author Jin Kwon &ltjinahya at gmail.com&gt;
 */
public class XletContextHolder extends AtomicHolder<XletContext> {


    private static final class InstanceHolder {


        private static final XletContextHolder INSTANCE
            = new XletContextHolder();


        private InstanceHolder() {

            super();
        }


    }


    /**
     * Returns the single instance of this holder. The {@code XletContextHolder}
     * is a singleton.
     *
     * @return the instance.
     */
    public static XletContextHolder getInstance() {

        return InstanceHolder.INSTANCE;
    }


    /**
     * Return the value which {@link #getInstance()} is holding. This method is
     * identical to {@code getInstance().get()}.
     *
     * @return the value.
     *
     * @see #getInstance()
     * @see #get()
     */
    public static XletContext getXletContext() {

        return getInstance().get();
    }


    /**
     * Replace the value which {@link #getInstance()} is holding. This method is
     * identical to {@code getInstance().set(holdee)}.
     *
     * @param value
     *
     * @see #getInstance()
     * @see #set(javax.tv.xlet.XletContext)
     */
    public static void setXletContext(final XletContext value) {

        getInstance().set(value);
    }


    /**
     * Returns the result of
     * {@link XletContext#getXletProperty(java.lang.String)} invoked with
     * specified {@code key} on the {@code XletContext} that this holder is
     * currently holding.
     *
     * @param key the key
     *
     * @return the value.
     *
     * @see #getXletContext()
     * @see XletContext#getXletProperty(java.lang.String)
     */
    public static Object getXletProperty(final String key) {

        return getXletContext().getXletProperty(key);
    }


    /**
     * Returns the Xlet property value mapped to {@link XletContext#ARGS}.
     *
     * @return the initialization arguments as an array of {@code String}.
     *
     * @see XletContext#ARGS
     * @see #getXletProperty(java.lang.String)
     */
    public static String[] getInitializationArguments() {

        return (String[]) getXletProperty(XletContext.ARGS);
    }


    /**
     * Invokes {@link XletContext#notifyDestroyed()} on the {@code XletContext}
     * instance that this holder is currently holding.
     *
     * @see #getXletContext()
     * @see XletContext#notifyDestroyed()
     */
    public static void notifyDestroyed() {

        getXletContext().notifyDestroyed();
    }


    /**
     * Invokes {@link XletContext#notifyPaused()} on the {@code XletContext}
     * instance that this holder is currently holding.
     *
     * @see #getXletContext()
     * @see XletContext#notifyPaused()
     */
    public static void notifyPaused() {

        getXletContext().notifyPaused();
    }


    /**
     * Invokes {@link XletContext#resumeRequest()} on the {@code XletContext}
     * that this holder is currently holding.
     *
     * @see #getXletContext()
     * @see XletContext#resumeRequest()
     */
    public static void resumeRequest() {

        getXletContext().resumeRequest();
    }


    private XletContextHolder() {

        super(null);
    }


}


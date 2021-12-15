module com.icuxika.kt.framework {
    requires java.base;
    requires kotlin.stdlib;
    requires org.slf4j;
    requires com.google.gson;

    exports com.icuxika.kt.framework;
    exports com.icuxika.kt.framework.extensions;
}
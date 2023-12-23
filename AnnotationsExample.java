import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationsExample {
    @Override
    @MethodInfo(author = "Rajat", comments = "Main method", date = "Dec 23 2023", revision = 1)
    public String toString() {
        return "Overridden toString method";
    }

    @Deprecated
    @MethodInfo(comments = "deprecated method", date = "Nov 17 2012")
    public static void oldMethod() {
        System.out.println("old method, don't use it.");
    }

    public static void main(String[] args) {
        try {
            for (Method method : AnnotationsExample.class.getMethods()) {
                // checks if MethodInfo annotation is present for the method
                if (method.isAnnotationPresent(MethodInfo.class)) {
                    try {
                        // iterates all the annotations available in the method
                        System.out.println("Annotation in Method '" + method +"->");
                        for (Annotation anno : method.getDeclaredAnnotations()) {
                            System.out.println(anno);
                        }
                        MethodInfo methodAnno = method.getAnnotation(MethodInfo.class);
                        if (methodAnno.revision() == 1)
                            System.out.println("Method with revision no 1 = " + method);
                        System.out.println();
                    } catch (Throwable ex) {
                        ex.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

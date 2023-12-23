import java. lang.annotation.Documented; 
import java. lang.annotation.ElementType; 
import java. lang.annotation.Inherited; 
import java. lang.annotation.Retention;
import java. lang.annotation.RetentionPolicy;
import java. lang.annotation.Target;

/*
* @Documented - Whether to put the annotation in Javadocs
* @Retention - When the annotation is needed
* @Target? - Places the annotation can go
* @Inherited - Whether subclasses get the annotation.
*/


@Documented
@Target (ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodInfo{
  String author() default "Karan";
  String date();
  int revision() default 1;
  String comments();
}
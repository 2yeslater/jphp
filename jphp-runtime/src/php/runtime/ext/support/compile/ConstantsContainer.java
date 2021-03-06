package php.runtime.ext.support.compile;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

abstract public class ConstantsContainer {

    public Collection<CompileConstant> getConstants(){
        List<CompileConstant> result = new ArrayList<CompileConstant>();
        for(Field field : getClass().getDeclaredFields()){
            field.setAccessible(true);
            try {
                result.add(new CompileConstant(field.getName(), field.get(this)));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }
}

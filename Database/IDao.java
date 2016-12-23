<#if package?? && package != "">
package ${package};

</#if>
import java.util.List;

/**
 * DAO Interface
 * @created on ${date}, ${time}
 * @author ${user}
 * @param <T>
 */
public interface ${name}<T> {

    List<T> get();

    long insert(T model);

    boolean update(T model);

    boolean delete(T model);

}

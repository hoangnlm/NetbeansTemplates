<#assign licenseFirst = "/*">
<#assign licensePrefix = " * ">
<#assign licenseLast = " */">
<#include "${project.licensePath}">

<#if package?? && package != "">
package ${package};

</#if>
/**
 *
 * @created on ${date}, ${time}
 * @author ${user}
 */
public class ${name} {

}

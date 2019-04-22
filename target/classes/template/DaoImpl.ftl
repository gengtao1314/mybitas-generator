package ${packageStr};

import org.springframework.stereotype.Repository;
${importStr}

/**
 * <pre>
 * Author	${author}
 * Version 	1.0
 * Date    ${time}
 * </pre>
 */
@Repository
public interface ${className} extends IMyBatisBaseDao<${entityClassName}, Long> {

}
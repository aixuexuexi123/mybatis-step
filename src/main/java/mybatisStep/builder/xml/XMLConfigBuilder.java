package mybatisStep.builder.xml;

import mybatisStep.builder.BaseBuilder;
import mybatisStep.session.Configuration;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.xml.sax.InputSource;

import javax.swing.text.Element;
import java.io.Reader;

/**
 * @Description XML配置构建器，建造者模式，继承BaseBuilder
 * @Date 2024/5/1 10:51
 * @Created by lenovo
 */
public class XMLConfigBuilder extends BaseBuilder {

    private Element root;

    public XMLConfigBuilder(Reader reader){
        // 1. 调用父类初始化Configuration
        super(new Configuration());
        // 2. dom4j 处理 xml
        SAXReader saxReader = new SAXReader();
        try {
            org.dom4j.Document document = saxReader.read(new InputSource(reader));
            root = (Element) document.getRootElement();

        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }

    }


}

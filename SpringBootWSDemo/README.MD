
WSDL URL:http://localhost:8008/lzg/soap/testWebService.wsdl

测试：
通过Postman调用：

URL:http://localhost:8008/lzg/soap/testWebService

参数：raw xml(text/xml)

请求报文：
	
	<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" 		xmlns:lzg="http://www.lzg.test.com">
   		<soapenv:Header/>
   		<soapenv:Body>
      		<lzg:doService>
        		<serviceCode>1111111</serviceCode>
        		<reqXml>22222222222</reqXml>
      		</lzg:doService>
   		</soapenv:Body>
	</soapenv:Envelope>
	

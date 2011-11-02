class WsdlDriver
    attr_accessor :client, :namespace, :response_object

    def initialize(wsdlUrl, ns=nil)

        self.client = Savon::Client.new do
            wsdl.document = wsdlUrl
        end

        self.namespace = ns
    end

    def namespace=(ns)
        @namespace = { "xmlns:ns2" => ns}
    end

    def namespace
        @namespace
    end

    def request(requestName, body)
        self.response_object = self.client.request(:ns2, requestName, namespace) do
            soap.body = !(body.class == Hash || body.class == String) ? body.to_xml : body
        end
        @requestClass = body.class
        @requestName = requestName.to_s
    end

    def response

        resp = self.response_object.body[(@requestName + "_response").to_sym]#[:return]

        if not (@requestClass == Hash || @requestClass == String)
            resp =  resp[:return].delete_if { |k,v| k.to_s.match(/^@/)}
            retobject = @requestClass.new
            resp.each do |k,v|
                retobject.send(k.to_s.camelize + "=", v)
            end
        else
            retobject = resp[:return]
        end


        return retobject
    end

end

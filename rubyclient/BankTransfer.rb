require 'happymapper'


class XMLSerializer
    include HappyMapper

    def remove_instruct(xml)
        return xml.split("?>\n")[1]
    end


    alias original_to_xml to_xml

    def to_xml(parent =nil, def_name = nil)
        data = original_to_xml(parent, def_name)
        remove_instruct(data) if data.class == String
    end

    def getTag
        return self.tag
    end
end

class DisbursementPreference < XMLSerializer

end


class BankTransfer < DisbursementPreference
    include HappyMapper
    attr_accessor :ns,:tag_name

    def initialize
        @ns = "ns2:bankTransfer"
        self.tag_name = 'bank'
    end

    tag 'bank'
    attribute "namespace", String, :tag => "xsi:type"
    namespace 'http://services.aic11.tuwien.ac.at'
    element :bankName, String
    element :bic, String
    element :iban, String

    def to_xml
        self.namespace = ns
        super
    end
end

class SoapMethodResponse
    include HappyMapper
end

class PushBankTransferResponse < SoapMethodResponse
    include HappyMapper
    tag 'pushBankTransferResponse'
    register_namespace 'ns2', 'http://foobar.demo/'
    namespace 'ns2'

    element :blub, String

end

class SoapBody < XMLSerializer
    include HappyMapper
    tag 'Body'
    namespace 'soap'
    #attribute "namespace", String, :tag => "xmlns:ns2"
    has_one :soap_method_response, SoapMethodResponse
end

class SoapEnvelope < XMLSerializer
    include HappyMapper
    register_namespace 'soap', 'http://schemas.xmlsoap.org/soap/envelope/'
#    attribute "namespace", String, :tag => "xmlns:soap"
    tag 'Envelope'
    namespace 'soap'
    #element :bankName, String
    has_one :soap_body, SoapBody
end


class SoapMessage < XMLSerializer
    include HappyMapper
    tag 'root'
    attribute "namespace", String, :tag => "xmlns:soap"
    has_one :soap_envelope, SoapEnvelope
end

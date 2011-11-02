require "rubygems"
require "savon"
require 'builder'
require 'WsdlDriver'
gem "soap4r"
#gem "unhappymapper"
require 'soap/wsdlDriver'
require 'BankTransfer'

class String
    def camelize
        ret = self.split(/[^a-z0-9]/i).map{ |w| w.capitalize}.join
        return ret[0,1].downcase + ret[1,self.length]
    end
end


bank = BankTransfer.new
bank.bankName = "omg"
bank.iban = "1234"
bank.bic = "1344"

wsdl_url = "http://localhost:9000/helloWorld?wsdl"
#wsdl_url = "http://vc.infosys.tuwien.ac.at:8092/registry?wsdl"

#a = bank.to_xml

y = SoapEnvelope.parse("
<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">
  <soap:Body>
      <ns2:pushBankTransferResponse xmlns:ns2=\"http://foobar.demo/\">
          <ns2:blub>rofl</ns2:blub>
      </ns2:pushBankTransferResponse>
  </soap:Body>
</soap:Envelope>
")

#print y.to_xml
Savon.configure do |c|
    c.log = false
end

client = WsdlDriver.new(wsdl_url, "http://foobar.demo/")

#response = client.request(:ns2, :query,"xmlns:ns2" => "http://services.aic11.infosys.tuwien.ac.at/") do
   # soap.namespaces["xmlns:ns2"] = "http://foobar.demo/"
#    soap.body = bank.to_xml
#end

client.request(:push_bank_transfer, bank)
#client.response[:return].delete_if { |k,v| k.to_s.match(/^@/)}
p client.response

#begin
#    response = client.request( :sayHi,"xmlns:ns2" => "http://foobar.demo/") do
#        soap.body = { :text => "omgwtfbbq"}
#    end

#    rescue Savon::SOAP::Fault
#    puts "error occured"
#end

#  soap.body = { :text => "hallo world"}

#p response.body[:say_hi_response][:return]

class CreditRequest
    extend ActiveModel::Naming
    include ActiveModel::Conversion
    include ActiveModel::Validations
    include Validatable

    Long = Rjb::import("java.lang.Long")
    IntegerJava = Rjb::import("java.lang.Integer")

    @warrantors = []
    attr_accessor :id, :customerId, :durationYears, :currencyCode, :amount, :reason, :warrantors

    validates_presence_of :id,:customerId,:currencyCode, :reason
    validates_numericality_of :customerId,:durationYears,:amount


    def numericality_of_warrantor(element,options={ })
        value = element.to_s
        regex = options[:only_integer] ? /\A[+-]?\d+\Z/ : /^\d*\.{0,1}\d+$/
        if (value =~ regex).nil?
     #       errors.add(:warrantors, "warrantor must be a number")
            return false
        end
        return true
    end

    def initialize(attributes = { })
        attributes.each do |name,value|
            send("#{name}=",value)
        end
    end

    def getWarrantors
        @warrantors
    end

    def addWarrantors(warrantor)
        @warrantors ||= []
        if @warrantors.include?(warrantor)
            retval = -1
        else
            if numericality_of_warrantor(warrantor)
                @warrantors << warrantor
                retval =  1
            else
                retval =  0
            end
        end
    end

    def validWarrantors
        @warrantors && @warrantors.size > 0
    end

    def removeWarrantors(warrantors)
        if @warrantors.include?(warrantors) == false
            return -1
        else
            @warrantors.delete(warrantors)
        end
    end

    def persisted?
        false
    end

    def toCreditRequest
        retVal = CreditRequestJava.new
        retVal.setId(Long.new(self.id))
        retVal.setCustomerId(Long.new(self.customerId))
        retVal.setDurationYears(IntegerJava.new(self.durationYears))
        retVal.setCurrencyCode(self.currencyCode)
        retVal.setAmount(Long.new(self.amount))
        retVal.setReason(self.reason)
        warrantorIds = LinkedList.new
        @warrantors.each do |w|
            warrantorIds.add(Long.new(w))
        end
        retVal.setWarrantorIds(warrantorIds)
        return retVal
    end

end


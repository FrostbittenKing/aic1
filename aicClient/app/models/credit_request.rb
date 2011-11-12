class CreditRequest
    extend ActiveModel::Naming
    include ActiveModel::Conversion
    include ActiveModel::Validations


    @warrantors = []
    attr_accessor :warrantors

    def initialize(attributes = { })
        attributes.each do |name,value|
            send("#{name}=",value)
        end
    end

    def getWarrantors
        @warrantors
    end

    def addWarrantors(warrantor)
        if @warrantors.include?(warrantor)
            return -1
        else
            @warrantors << warrantor
        end
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
end

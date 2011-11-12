module Rjb
    class FOO
        extend ActiveModel::Naming
        include ActiveModel::AttributeMethods
        include ActiveModel::Conversion

        def self.trololo
            p "rofl"
        end
    end
end

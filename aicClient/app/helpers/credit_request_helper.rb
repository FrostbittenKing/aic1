module CreditRequestHelper
    def error_messages_for_attribute(object, attribute)
        errors = object.errors.on(attribute)
        "#{ERB::Util.html_escape(errors.is_a?(Array) ? errors.first : errors)}"
    end
end

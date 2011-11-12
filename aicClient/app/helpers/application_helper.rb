module ApplicationHelper
    def title
        base_title = "Credit Approval Process Client"
        if @title.nil?
            base_title
        else
           "#{base_title} | #{@title}"
        end
    end
end

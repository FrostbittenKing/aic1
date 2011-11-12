class CreditRequestsController < ApplicationController
    require 'rjb'
    Long = Rjb::import("java.lang.Long")

    def new
        @title = "create"
        @credit_request = (session[:current_request] || CreditRequest.new)
        session[:current_request] ||= @credit_request
    end

    def create
        @credit_request = session[:current_request]
        if params[:add_warrantor]
            p params[:credit_request][:warrantors][:name]
            retval = @credit_request.addWarrantors(params[:credit_request][:warrantors][:name])
            if retval != -1
                flash[:success] = "warrantor #{params[:credit_request][:warrantors][:name]} added"
            else
                flash[:error] = "warrantor   #{params[:credit_request][:warrantors][:name]} already exists"
            end
        elsif params[:remove_warrantor]
            retval = @credit_request.removeWarrantors(params[:credit_request][:warrantors][:name])
            if retval == -1
                flash[:error] = "Warrantor #{params[:credit_request][:warrantors][:name]} does not exist"
            else
                flash[:success] = "Warrantor #{params[:credit_request][:warrantors][:name]} removed"
            end
        end
#        p @credit_request.getWarrantors
        render :action => :new
    end

end

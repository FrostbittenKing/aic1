class CreditRequestsController < ApplicationController
    require 'rjb'


    def new
        @title = "create"
        @credit_request = session[:credit_request]
        @credit_request ||= CreditRequest.new
        session[:credit_request] = @credit_request

    end

    def create
        @credit_request = session[:credit_request]


        if params[:add_warrantor]
            retval = @credit_request.addWarrantors(params[:credit_request][:warrantors][:warrantors])

            if retval == 1
                flash[:success] = "warrantor #{params[:credit_request][:warrantors][:name]} added"
            elsif retval == -1
                flash[:error] = "warrantor   #{params[:credit_request][:warrantors][:name]} already exists"
            else
                flash[:error] = "warrantor should be a number"
            end

        elsif params[:remove_warrantor]
            retval = @credit_request.removeWarrantors(params[:credit_request][:warrantors][:warrantors])
            if retval == -1
                flash[:error] = "Warrantor #{params[:credit_request][:warrantors][:name]} does not exist"
            else
                flash[:success] = "Warrantor #{params[:credit_request][:warrantors][:name]} removed"
            end

        end

        request_params = params[:credit_request][:warrantors]
        @credit_request.id = 42
        @credit_request.valid?
        @credit_request.customerId = request_params[:customerId] == "" ? @credit_request.customerId : request_params[:customerId]
        @credit_request.durationYears = request_params[:durationYears] == "" ? @credit_request.durationYears : request_params[:durationYears]
        @credit_request.currencyCode = request_params[:currencyCode] == "" ?  @credit_request.currencyCode : request_params[:currencyCode]
        @credit_request.amount = request_params[:amount] == "" ?  @credit_request.amount : request_params[:amount]
        @credit_request.reason = request_params[:reason] == "" ?  @credit_request.reason : request_params[:reason]

        if @credit_request.valid? && @credit_request.validWarrantors
            begin
                clerkController = Clerk.getInstance #Rjb::import("at.ac.tuwien.infosys.aic11.Clerk").getInstance

                clerkController.createRequest(@credit_request.toCreditRequest)
                flash[:success] = "request sent"
            rescue => msg
                if msg.class.name == "NoSuchCustomerException"
                    flash[:error] = "customer with id #{@credit_request.customerId} doesn't exist"
                end
            end
        else
            p "foobar"
        end
        session[:credit_request] = @credit_request
        render :action => :new

        flash[:errors] = nil

    end



end

require 'spec_helper'

describe PagesController do

  describe "GET 'credit_request'" do
    it "returns http success" do
      get 'credit_request'
      response.should be_success
    end
  end

end

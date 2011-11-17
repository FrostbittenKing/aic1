require 'spec_helper'

describe OffersController do

  describe "GET 'getRating'" do
    it "returns http success" do
      get 'getRating'
      response.should be_success
    end
  end

  describe "GET 'generateOffer'" do
    it "returns http success" do
      get 'generateOffer'
      response.should be_success
    end
  end

  describe "GET 'placeOffer'" do
    it "returns http success" do
      get 'placeOffer'
      response.should be_success
    end
  end

end

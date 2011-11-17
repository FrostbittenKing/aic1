# Load the rails application
require File.expand_path('../application', __FILE__)
require 'validatable'

# Initialize the rails application
AicClient::Application.initialize!

ENV['CXF_LIB_PATH'] = "#{ENV['CXF_HOME']}/lib/"
Rjb::load("../ClerkLibrary/bin/:" + Dir.glob(ENV['CXF_LIB_PATH'] + "*.jar").join(":"))

CreditRequestJava = Rjb::import("at.ac.tuwien.infosys.aic11.dto.Request")
LinkedList = Rjb::import("java.util.LinkedList")
Long = Rjb::import("java.lang.Long")
Clerk = Rjb::import("at.ac.tuwien.infosys.aic11.Clerk")
#NoSuchCustomerException = Rjb::import("aic.domain.NoSuchCustomerException")

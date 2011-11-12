# Load the rails application
require File.expand_path('../application', __FILE__)

# Initialize the rails application
AicClient::Application.initialize!

ENV['CXF_LIB_PATH'] = "#{ENV['CXF_HOME']}/lib/"
Rjb::load("../ClerkLibrary/bin/:" + Dir.glob(ENV['CXF_LIB_PATH'] + "*.jar").join(":"))

p Rjb::import("aic.domain.dto.Request")

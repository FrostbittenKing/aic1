# Load the rails application
require File.expand_path('../application', __FILE__)

# Initialize the rails application
AicClient::Application.initialize!
p ENV['JAVA_HOME']

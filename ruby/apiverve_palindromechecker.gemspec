# frozen_string_literal: true

Gem::Specification.new do |spec|
  spec.name          = "apiverve_palindromechecker"
  spec.version       = "1.2.2"
  spec.authors       = ["APIVerve"]
  spec.email         = ["hello@apiverve.com"]

  spec.summary       = "Palindrome Checker API - Ruby Client"
  spec.description   = "Palindrome Checker tests whether a string reads the same forwards and backwards, with options to ignore casing, spacing, and punctuation. It returns the boolean verdict, the normalized text, the reversed comparison string, and the length of the longest palindromic sequence."
  spec.homepage      = "https://apiverve.com/marketplace/palindromechecker?utm_source=ruby&utm_medium=referral&utm_content=homepage"
  spec.license       = "MIT"
  spec.required_ruby_version = ">= 2.7.0"

  spec.metadata["homepage_uri"] = spec.homepage
  spec.metadata["source_code_uri"] = "https://github.com/apiverve/palindromechecker-API/tree/main/ruby"
  spec.metadata["changelog_uri"] = "https://apiverve.com/changelog"
  spec.metadata["documentation_uri"] = "https://docs.apiverve.com/ref/palindromechecker"

  spec.files = Dir.glob("{lib}/**/*") + %w[README.md LICENSE]
  spec.require_paths = ["lib"]

  spec.add_dependency "faraday", ">= 1.0", "< 3.0"
  spec.add_dependency "faraday-multipart", "~> 1.0"
  spec.add_dependency "json", "~> 2.0"
end

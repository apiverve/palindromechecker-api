# Palindrome Checker API - Ruby Gem

Palindrome Checker tests whether a string reads the same forwards and backwards, with options to ignore casing, spacing, and punctuation. It returns the boolean verdict, the normalized text, the reversed comparison string, and the length of the longest palindromic sequence.

## Installation

Add this line to your application's Gemfile:

```ruby
gem 'apiverve_palindromechecker'
```

And then execute:

```bash
$ bundle install
```

Or install it yourself as:

```bash
$ gem install apiverve_palindromechecker
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```ruby
require 'apiverve_palindromechecker'

# Initialize the client
client = APIVerve::Palindromechecker::Client.new(api_key: "YOUR_API_KEY")

# Make a request
response = client.execute({
  text: "A man a plan a canal Panama",
  ignorecase: true,
  ignorespaces: true,
  ignorepunctuation: true
})

# Print the response
puts response
```


### Error Handling

```ruby
begin
  response = client.execute({ text: "A man a plan a canal Panama", ignorecase: true, ignorespaces: true, ignorepunctuation: true })
  puts response["data"]
rescue APIVerve::Palindromechecker::ValidationError => e
  puts "Validation error: #{e.errors.join(', ')}"
rescue APIVerve::Palindromechecker::APIError => e
  puts "API error: #{e.message}"
  puts "Status code: #{e.status_code}"
end
```

### Debug Mode

```ruby
# Enable debug logging
client = APIVerve::Palindromechecker::Client.new(
  api_key: "YOUR_API_KEY",
  debug: true
)
```

## Example Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "text": "A man a plan a canal Panama",
    "is_palindrome": true,
    "cleaned_text": "amanaplanacanalpanama",
    "reversed_text": "amanaplanacanalpanama",
    "length": 21,
    "options": {
      "ignore_case": true,
      "ignore_spaces": true,
      "ignore_punctuation": true
    },
    "longest_palindrome_substring": "amanaplanacanalpanama",
    "longest_palindrome_length": 21
  }
}
```

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/palindromechecker?utm_source=rubygems&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/palindromechecker?utm_source=ruby&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/palindromechecker?utm_source=ruby&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This gem is available under the [MIT License](LICENSE).

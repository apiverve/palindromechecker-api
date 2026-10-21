# Palindrome Checker API - PHP Package

Palindrome Checker tests whether a string reads the same forwards and backwards, with options to ignore casing, spacing, and punctuation. It returns the boolean verdict, the normalized text, the reversed comparison string, and the length of the longest palindromic sequence.

## Installation

Install via Composer:

```bash
composer require apiverve/palindromechecker
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```php
<?php

require_once 'vendor/autoload.php';

use APIVerve\Palindromechecker\Client;

// Initialize the client
$client = new Client('YOUR_API_KEY');

// Make a request
$response = $client->execute([
    'text' => 'A man a plan a canal Panama',
    'ignorecase' => true,
    'ignorespaces' => true,
    'ignorepunctuation' => true
]);

// Print the response
print_r($response);
```


### Error Handling

```php
use APIVerve\Palindromechecker\Client;
use APIVerve\Palindromechecker\Exceptions\APIException;
use APIVerve\Palindromechecker\Exceptions\ValidationException;

try {
    $response = $client->execute(['text' => 'A man a plan a canal Panama', 'ignorecase' => true, 'ignorespaces' => true, 'ignorepunctuation' => true]);
    print_r($response['data']);
} catch (ValidationException $e) {
    echo "Validation error: " . implode(', ', $e->getErrors());
} catch (APIException $e) {
    echo "API error: " . $e->getMessage();
    echo "Status code: " . $e->getStatusCode();
}
```

### Debug Mode

```php
// Enable debug logging
$client = new Client(
    apiKey: 'YOUR_API_KEY',
    debug: true
);
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

## Requirements

- PHP 7.4 or higher
- Guzzle HTTP client

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/palindromechecker?utm_source=packagist&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/palindromechecker?utm_source=php&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/palindromechecker?utm_source=php&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This package is available under the [MIT License](LICENSE).

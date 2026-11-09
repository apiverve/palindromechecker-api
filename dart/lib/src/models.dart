/// Response models for the Palindrome Checker API.

/// API Response wrapper.
class PalindromecheckerResponse {
  final String status;
  final dynamic error;
  final PalindromecheckerData? data;

  /// Set only when the current plan locks one or more fields; null otherwise.
  final PremiumInfo? premium;

  PalindromecheckerResponse({
    required this.status,
    this.error,
    this.data,
    this.premium,
  });

  factory PalindromecheckerResponse.fromJson(Map<String, dynamic> json) => PalindromecheckerResponse(
    status: json['status'] as String? ?? '',
    error: json['error'],
    data: json['data'] != null ? PalindromecheckerData.fromJson(json['data']) : null,
    premium: json['premium'] != null ? PremiumInfo.fromJson(json['premium']) : null,
  );

  Map<String, dynamic> toJson() => {
    'status': status,
    if (error != null) 'error': error,
    if (data != null) 'data': data,
    if (premium != null) 'premium': premium!.toJson(),
  };
}

/// Describes fields the current plan does not unlock. Locked fields arrive as null
/// in [data], and [lockedFields] names them (nested ones use dot paths).
class PremiumInfo {
  final String? message;
  final String? upgradeUrl;
  final List<String>? lockedFields;

  PremiumInfo({this.message, this.upgradeUrl, this.lockedFields});

  factory PremiumInfo.fromJson(Map<String, dynamic> json) => PremiumInfo(
    message: json['message'] as String?,
    upgradeUrl: json['upgrade_url'] as String?,
    lockedFields: (json['locked_fields'] as List?)?.map((e) => e.toString()).toList(),
  );

  Map<String, dynamic> toJson() => {
    if (message != null) 'message': message,
    if (upgradeUrl != null) 'upgrade_url': upgradeUrl,
    if (lockedFields != null) 'locked_fields': lockedFields,
  };
}

/// Response data for the Palindrome Checker API.

class PalindromecheckerData {
  String? text;
  bool? isPalindrome;
  String? cleanedText;
  String? reversedText;
  num? length;
  PalindromecheckerDataOptions? options;
  String? longestPalindromeSubstring;
  num? longestPalindromeLength;

  PalindromecheckerData({
    this.text,
    this.isPalindrome,
    this.cleanedText,
    this.reversedText,
    this.length,
    this.options,
    this.longestPalindromeSubstring,
    this.longestPalindromeLength,
  });

  factory PalindromecheckerData.fromJson(Map<String, dynamic> json) => PalindromecheckerData(
      text: json['text'],
      isPalindrome: json['is_palindrome'],
      cleanedText: json['cleaned_text'],
      reversedText: json['reversed_text'],
      length: json['length'],
      options: json['options'] != null ? PalindromecheckerDataOptions.fromJson(json['options']) : null,
      longestPalindromeSubstring: json['longest_palindrome_substring'],
      longestPalindromeLength: json['longest_palindrome_length'],
    );
}

class PalindromecheckerDataOptions {
  bool? ignoreCase;
  bool? ignoreSpaces;
  bool? ignorePunctuation;

  PalindromecheckerDataOptions({
    this.ignoreCase,
    this.ignoreSpaces,
    this.ignorePunctuation,
  });

  factory PalindromecheckerDataOptions.fromJson(Map<String, dynamic> json) => PalindromecheckerDataOptions(
      ignoreCase: json['ignore_case'],
      ignoreSpaces: json['ignore_spaces'],
      ignorePunctuation: json['ignore_punctuation'],
    );
}

class PalindromecheckerRequest {
  String text;
  bool? ignorecase;
  bool? ignorespaces;
  bool? ignorepunctuation;

  PalindromecheckerRequest({
    required this.text,
    this.ignorecase,
    this.ignorespaces,
    this.ignorepunctuation,
  });

  Map<String, dynamic> toJson() => {
      'text': text,
      if (ignorecase != null) 'ignorecase': ignorecase,
      if (ignorespaces != null) 'ignorespaces': ignorespaces,
      if (ignorepunctuation != null) 'ignorepunctuation': ignorepunctuation,
    };
}

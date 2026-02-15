using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.PalindromeChecker
{
    /// <summary>
    /// Query options for the Palindrome Checker API
    /// </summary>
    public class PalindromeCheckerQueryOptions
    {
        /// <summary>
        /// The text to check for palindrome
        /// </summary>
        [JsonProperty("text")]
        public string Text { get; set; }

        /// <summary>
        /// Ignore case when checking (default: true)
        /// </summary>
        [JsonProperty("ignorecase")]
        public string Ignorecase { get; set; }

        /// <summary>
        /// Ignore spaces when checking (default: true)
        /// </summary>
        [JsonProperty("ignorespaces")]
        public string Ignorespaces { get; set; }

        /// <summary>
        /// Ignore punctuation when checking (default: true)
        /// </summary>
        [JsonProperty("ignorepunctuation")]
        public string Ignorepunctuation { get; set; }
    }
}

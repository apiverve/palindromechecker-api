declare module '@apiverve/palindromechecker' {
  export interface palindromecheckerOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface palindromecheckerResponse {
    status: string;
    error: string | null;
    data: PalindromeCheckerData;
    code?: number;
  }


  interface PalindromeCheckerData {
      text:                       string;
      isPalindrome:               boolean;
      cleanedText:                string;
      reversedText:               string;
      length:                     number;
      options:                    Options;
      longestPalindromeSubstring: string;
      longestPalindromeLength:    number;
  }
  
  interface Options {
      ignoreCase:        boolean;
      ignoreSpaces:      boolean;
      ignorePunctuation: boolean;
  }

  export default class palindromecheckerWrapper {
    constructor(options: palindromecheckerOptions);

    execute(callback: (error: any, data: palindromecheckerResponse | null) => void): Promise<palindromecheckerResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: palindromecheckerResponse | null) => void): Promise<palindromecheckerResponse>;
    execute(query?: Record<string, any>): Promise<palindromecheckerResponse>;
  }
}

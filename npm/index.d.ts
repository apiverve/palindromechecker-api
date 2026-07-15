declare module '@apiverve/palindromechecker' {
  export interface palindromecheckerOptions {
    api_key: string;
    secure?: boolean;
  }

  /**
   * Describes fields the current plan does not unlock. Locked fields arrive as null
   * in `data`; `locked_fields` names them, using dot paths for nested fields.
   * Absent when the plan unlocks everything.
   */
  export interface PremiumInfo {
    message: string;
    upgrade_url: string;
    locked_fields: string[];
  }

  export interface palindromecheckerResponse {
    status: string;
    error: string | null;
    data: PalindromeCheckerData;
    code?: number;
    premium?: PremiumInfo;
  }


  interface PalindromeCheckerData {
      text:                       null | string;
      isPalindrome:               boolean | null;
      cleanedText:                null | string;
      reversedText:               null | string;
      length:                     number | null;
      options:                    Options;
      longestPalindromeSubstring: null | string;
      longestPalindromeLength:    number | null;
  }
  
  interface Options {
      ignoreCase:        boolean | null;
      ignoreSpaces:      boolean | null;
      ignorePunctuation: boolean | null;
  }

  export default class palindromecheckerWrapper {
    constructor(options: palindromecheckerOptions);

    execute(callback: (error: any, data: palindromecheckerResponse | null) => void): Promise<palindromecheckerResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: palindromecheckerResponse | null) => void): Promise<palindromecheckerResponse>;
    execute(query?: Record<string, any>): Promise<palindromecheckerResponse>;
  }
}

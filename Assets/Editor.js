// ===============================
//  1. キーワード辞書
// ===============================
const keywordColors = {};


// ===============================
//  2. CSV ローダー
// ===============================
async function loadCSV(url) {
    const res = await fetch(url);
    const text = await res.text();
    const lines = text.split("\n");

    for (const line of lines) {
        const m = line.match(/"(.+?)",(.+)/);
        if (!m) continue;

        const categoryWord = m[1];
        const colorName = m[2].trim();

        const parts = categoryWord.split(",");
        const word = parts[1];

        const hex = getColor(colorName);
        keywordColors[word] = hex;
    }
}


// ===============================
//  3. トークン分割
// ===============================
function tokenize(code) {
    return code.split(/(\s+|==|!=|<=|>=|=>|::|->|\.\.|\.|,|\(|\)|\{|\}|

\[|\]

|;|\+|-|\*|\/|%|&|\||\^|!|<|>|\?|:)/);
}


// ===============================
//  4. シンタックスハイライト
// ===============================
function highlightCode(code) {
    const tokens = tokenize(code);

    return tokens.map(t => {
        const color = keywordColors[t];
        if (color) {
            return `<span style="color:${color}">${t}</span>`;
        }
        return t;
    }).join("");
}


// ===============================
//  5. Editor バインド（IDE 方式）
// ===============================
function bindEditor() {
    const input = document.getElementById("editor");
    const highlight = document.getElementById("highlight");

    input.addEventListener("input", () => {
        highlight.innerHTML = highlightCode(input.value);
    });

    input.addEventListener("scroll", () => {
        highlight.scrollTop = input.scrollTop;
        highlight.scrollLeft = input.scrollLeft;
    });
}


// ===============================
//  6. 全辞書ロード
// ===============================
async function loadAllDictionaries() {
    await loadCSV("https://raw.githubusercontent.com/frisk-V3/V3-Editor/refs/heads/main/code%20list/C%23.csv");
    await loadCSV("https://raw.githubusercontent.com/frisk-V3/V3-Editor/refs/heads/main/code%20list/C%23Unity.csv");
    await loadCSV("https://raw.githubusercontent.com/frisk-V3/V3-Editor/refs/heads/main/code%20list/Python.csv");
    await loadCSV("https://raw.githubusercontent.com/frisk-V3/V3-Editor/refs/heads/main/code%20list/javascript.csv");
}

/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ['./resources/js/app.js'],
  theme: {
      colors: {
        'bg1': '#1A1826',
        'bg2': '#555568',
        'fg1': '#e9efec',
        'fg2': '#ffffff',
        'hl1': '#8EBABF'
      },
    extend: {
      'font-family': {
        'body': '"Jetbrains Mono"',
      },
    },
  },
  plugins: [],
}

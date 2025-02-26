/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    './src/**/*.{html,js,cljs,cljc}',  // Added cljs and cljc
  ],
  darkMode: 'class',
  theme: {
    fontSize: {
      xs: ['0.75rem', { lineHeight: '1rem' }],
      sm: ['0.875rem', { lineHeight: '1.5rem' }],
      base: ['1rem', { lineHeight: '1.75rem' }],
      lg: ['1.125rem', { lineHeight: '2rem' }],
      xl: ['1.25rem', { lineHeight: '2rem' }],
      '2xl': ['1.5rem', { lineHeight: '2rem' }],
      '3xl': ['2rem', { lineHeight: '2.5rem' }],
      '4xl': ['2.5rem', { lineHeight: '3.5rem' }],
      '5xl': ['3rem', { lineHeight: '3.5rem' }],
      '6xl': ['3.75rem', { lineHeight: '1' }],
      '7xl': ['4.5rem', { lineHeight: '1.1' }],
      '8xl': ['6rem', { lineHeight: '1' }],
      '9xl': ['8rem', { lineHeight: '1' }],
    },
    extend: {
      colors: { 
        mockingbird: {"main": "#FF009E", "100": "#AA397F", "400":"#A9397E", "500": "#D42490", "600": "#e90562", "700": "#66003F", "text":"#55394A"},
        nightjar: {"main": "#E0D94A", "bg": "#36362C"},
        kiwi: {"main": "#7FE04A", "bg": "#2F362C"},
        warning: {"50": "#fde8e8", "900": "#F05252"},
        success: {"50": "#def7ec", "700": "#046c4e"},
      },
      transitionProperty: {
        'width': 'width'
      },
      textDecoration: ['active'],
      minWidth: {
        'kanban': '28rem'
      },
    },
    fontFamily: {
      'jet': ["Jetbrains Mono"],
    }
  },
  plugins: [],
}

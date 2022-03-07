export interface Post {
    id: string;
    titulo: string;
    conteudo: string;
    upvotes: number;
    downvotes: number;
    updatingDate: string;
    idUsuario: string;
    imageLinks: string[];
}
